function Pellet() {
    this.phantoms = Array.prototype.slice.call(arguments, 0);
};

Pellet.prototype.eaten = function( aPacman ) {
    this.phantoms.forEach( p => p.weaken() );
};

module.exports = Pellet;

