# Dojo#4

Participantes

omitido adrede.

## Qué hicimos durante el dojo?

Abordamos el ejercicio [Dojo#4](https://github.com/diegosanchez/dojo/tree/workshop/dojo_4) codificando los casos de prueba propuestos para el dojo prestando particular atención en los dos últimos casos.

## Qué ideas surgieron durante y/o problemas el dojo?

1. Checked - No definir métodos para consultar el estado de un objeto.
2. Checked - Cambio de comportamiento en función del estado de un objeto (patrón Strategy).

## Cronología de la actividad

Estuvimos trabajando en escribir el código para los siguientes tests (listo a modo de ayuda memoria):

```js
describe("pacman", () => {
    it("should get fat whether it eats biscuits", () => {
        // code here
    });

    it("should get fat whether it eats biscuits", () => {
        // code here
    });

    it("should die whether bumps into phanton", () => {
        // code here
    });

    it("should weaken phantom whether it eats a pellet", () => {
        // code here
    });
});
```

Comenzamos escribiendo el código **MÍNIMO** necesario para que nuestros primeros tests pasen poniendo especial atención y cuidado en el código que escribímos ya que este será la interface de las entidades de nuestro modelo.

Los primeros tests son fáciles y nos permitieron aplicar las ideas que veniamos viendo en dojos anteriores. Listo una posible interfaces para estos tests:

```js
describe("pacman", () => {
    it("should get fat whether it eats biscuits", () => {
        var pacman = new Pacman();
        pacman.eat( new Biscuit() );

        chai.assert.equal(pacman.weight(), 1);
    });

    it("should get fat whether it eats biscuits", () => {
        var pacman = new Pacman();
        pacman.eat( new Biscuit() );
        pacman.eat( new Biscuit() );

        chai.assert.equal(pacman.weight(), 2);
    });
});
```

Cuando consideramos el siguiente caso de uso, la cosa se pone más interesante.

```js
    it("should die whether bumps into phanton", () => {
        var pacman = new Pacman();
        var inky = new Inky();

        pacman.bumpsInto( inky );

        chai.assert.equal(pacman.isDead(), true);
        chai.assert.equal(pacman.isAlive(), false);

    });
```

En este caso se produce una interacción entre el ```Pacman``` y el ```Fantasma``` cuyo resultado es que el primero pierde su vida. Hasta aquí nada nuevo bajo el sol. Si bien en este punto escribimos el código mínimo y necesario para que el test pase es importante notar que el comportamiento del ```Pacman``` y del ```Fantasma``` va a depender del estado de este último.


### Métodos para consultar estado de un objeto

Continuamos con el siguiente tests (escribiendo el código de este test surgen al mismo tiempo todos los conceptos que surgieron en el dojo).

Listo la propuesta inicial que surgió durante el evento:

```js
    it("should weaken phantom whether it eats a pellet", () => {
        var pacman = new Pacman();
        var inky = new Inky();
        var pellet = new Pellet(inky);

        pacman.eat( pellet );

        chai.assert.equal(inky.isWeakened(), true);
    });
```

Nos preguntamos si el método ```isWeakened()``` lo definimos a los efectos del tests o es algo necesario para que nuestro modelo resuelva el problema.  La respuesta fue tal que evidenciaba que este método solo se creó a los efectos del test; esto tiene varias implicancia (*negativas* según mi opinión) a saber:

1. Implica que los usuarios de la clase ```Inky``` van a consultar el estado del ```Fantasma``` y en función de su resultado tomarán una acción. Esto viola el principio de diseño [Tell, don't ask](https://martinfowler.com/bliki/TellDontAsk.html).
2. El ```Fantasma``` puede adquirir más de un estado que serán conocidos por todos los usuarios de esta clase. Atenta contra la extensibilidad y rompe el encapsulamiento.
3. No evidancia la verdadera lógica de negocio (el ```Pacman``` puede devorar al ```Fantasma``` porque este está debilitado). De mantenerse esta interfase (```Inky>>isWeakened()```) la lógica de negocio quedará en la clase que consulta este estado. Si mañana el fantasma adquiere otro estado (por cambios de requerimientos) el código de esta clase (la que consume ```>>isWeakened```) irá incrementando su tamaño. Con el consiguiente aumento en el número de responsabilidades violando el principio de Single Responsability.

Cuál es el aprendisaje:

> Reducir y/o procrastinar el número de métodos para consultar el estado de un objeto (getters). (Cuestión 1)

En lugar de hacer esto la alternativa (deseable) que surgió es escribir en el test la lógica de negocio involucrada en el test. 

```js
    it("should weaken phantom whether it eats a pellet", () => {
        var pacman = new Pacman();
        var inky = new Inky();
        var pellet = new Pellet(inky);

        pacman.eat( pellet );

        // El pacman puede devorar al fantasma deshabilitado y no morir
        var digestion = pacman.bumpsInto( inky );

        // El pacman puede devorar al fantasma zombie y  no morir
        var digestion = pacman.bumpsInto( inky );

        chai.assert.equal(pacman.isDead(), false);
        chai.assert.equal(pacman.isAlive(), true);
    });
```

El ```Pacman``` puede comer al ```Fantasma``` debilitado y no muere.  Producto de esta acción (devorar) se produce la digestión del ```Pacman``` que en este caso puntual será un ```Fantasma``` sin cuerpo (los ojitos volviendo a la base). Lo ven! Se ve como el ```Fantasma``` tiene más de un estado y esto va a ir incrementandose?!

La interacción ```Pacman``` - ```Fantasma``` puede depender de los estados del ```Fantasma``` por este motivo la responsabilidad de reaccionar de manera diferente será del ```Fantasma```. A los efectos de abordar esta solución surgió la idea de implementar el comportamiento del ```Fantasma``` utilizando el patrón [Strategy](https://en.wikipedia.org/wiki/Strategy_pattern).  

### Patrón States o Strategy

El ```Fantasma``` puede estar en varios estados que son mutuamente excluyentes:

- Normal o Initial.
- Weakened.
- Zombie.

Caundo el ```Pacman``` choca con el ```Fantasma``` el resultado de la interacción dependerá del estado del ```Fantasma```. Listo una posible solución para la clase ```Fantasma```:

```js
const NormalState = require('./normal_state');
const WeakenedState = require('./weakened_state');
const ZombieState = require('./zombie_state');

function Inky() {
    this.state = new NormalState();
};

Inky.prototype.weaken = function() {
    this.state = new WeakenedState();
}

Inky.prototype.swallowedBy = function(aPacman) {
    this.state = new ZombieState();
    return this;
};

Inky.prototype.bumpsInto = function(aPacman) {
    return this.state.collide( aPacman, this);
};

module.exports = Inky;
```

La responsabilidad del ```Fantasma``` es conocer de sus estados y poder "chocar" con el ```Pacman``` y la responsabidad de reaccionar en función de su estado la delega en los estados.

El estado ```Normal``` podría ser el siguiente:

```js
function NormalState() {
};

NormalState.prototype.collide = function(aPacman, aPhantom) {
    aPacman.die();
};

module.exports = NormalState;
```

El estado ```Weakened``` podría ser el siguiente:

```js
function WakenedState() {
};

WakenedState.prototype.collide = function(aPacman, aPhantom) {
    return aPacman.swallow( aPhantom );
};

module.exports = WakenedState;
```

El estado ```Zombie``` podría ser el siguiente:

```js
function ZombieState() {
};

ZombieState.prototype.collide = function(aPacman, aPhantom) {
    return aPhantom;
};

module.exports = ZombieState;
```

### Conlusiones

Al evitar el getter (isWeakened) nuestro modelo es tal que:

- Cada una de las clases tiene una única responsabilidad (Pacman, Inky o Fantasma, NormalState, ZombieState, Weakened).
- Cumple con el principio de Tell, don't ask.
- La lógica de negocio asociado a este método (isWeakened) queda encasulada en el Fantasma.

### To be continued...
