### Sistema de viajes 

Una empresa de viajes vende pasajes a destinos turísticos. Estos viajes podrían contar con varios tramos realizandose en distintos medios de transportes. 

Un viaje cuenta con varios tramos que determinará el costo del tramo. El precio de venta de un viaje es la sumatoria de todos los tramos más el márgen de ganancia. 

Contamos con una API externa que nos permite conocer el porcentaje de pasaje de viajes vendidos hasta la fecha.

En función de la disponibilidad los precios del los viajes varian según las sigiuentes reglas:
- Si 180 días antes del viaje se vendío un 80% de las plazas entonces el costo del viaje se incrementa un %20, sino el precio se reduce en un %10.
- Si 90 días antes del viaje resta vender un %10 de las plazas entonces el incremento es del %50, sino el precio se reduce un %20.
- 15 días antes el costo del viaje si incrementa un %10 fijo (independientemente de la disponibilidad).
- La semaman anterior se vende los viajes a un precio igual al costo más un monto fije de 100 (independientemente de la disponibilidad).
 

                                                                                                                 viaje

        Se vendió > %80                                   Resta %10
        incremento: %20                                   incremento: %20                              incremento: %10
        decremento: %5                                    decremento: %5                                          + 100
------------- | ------------------------------------------------ | ----------------------------------------- | -- S |
            180                                                 90                                          15  
            d                                                   d                                           d

El objetivo del ejercicio es poder ofrecerle a un potencialcliente cuanto debería pagar por un pasaje para n personas en un momento determinado. 


### Metodología

Programación orientada a objetos + TDD

### Agenda

1. Planteo de problema (5 minutos)
2. Codificación (30 - 40 minutos)
3. Puesta en común (Hasta el final)

## Pasos para realizar el workshop 

1. Clonamos el repo:

    ```bash
        git clone https://github.com/diegosanchez/dojo.git
    ```

2. Descargamos el branch remote correspondiente al workshop:

    ```bash
        git checkout workshop
    ```

### Pasos específicos para javascript

1. Instalamos módulos

    ```bash
        npm install
    ```

2. Ejecutamos los tests

    ```bash
        npm run test
    ```
    
    o
    
    ```bash
        make
    ```

#### Qué necesito?

2. node 4.2.3
3. npm  2.14.7


### Pasos específicos para java

1. Ejecutamos los tests

    ```bash
        mvn test
        ( Estando en la carpeta que contiene el pom.xml )
    ```



#### Qué necesito?

1. Maven 3+ ( brew install maven )
2. JDK 1.7 u 1.8## Pasos para realizar el workshop


## Qué necesito?

1. Notebook para realizar workshop (si queres hacerlo, sino podes venir a compartir tus experiencias)
2. Ganas de compartir tu solución.

## Cambio de requerimientos

- Grupo familiar.
- Menores de 3 años no paggan.
