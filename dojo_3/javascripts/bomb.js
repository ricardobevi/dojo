var Explosion = require('./explosion');

function Bomb( _releasePlace) { 
    this.releasePlace = _releasePlace;
    this.expiration = 2 // number of ticks;
};

Bomb.prototype.ticks = function() {
    this.expiration--;

    if (this.expiration) {
        return null;
    }

    return new Explosion( this.releasePlace /* epicenter */);
};

module.exports = Bomb;

