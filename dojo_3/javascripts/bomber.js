var Bomb = require('./bomb');
var Trayectory = require('./trayectory');

function Bomber( bornPlace) {
    this.where = bornPlace;
    this.lives = 100;
};

/***
 * @param   {Object}    dest    where it moves
 *
 */
Bomber.prototype.stepsIn = function stepsIn( place ) {
    this.stepsOut( this.where );
    place.reclaimedBy(this);
    this.where = place;
    return this;
};

Bomber.prototype.stepsOut = function stepsOut( place ) {
    place.releasedBy(this);
}

Bomber.prototype.bumpsIntoBagulaa = function(bagulaa) {
    this.lives = 0;
}

Bomber.prototype.isDead = function() {
    return this.lives <= 0;
}

Bomber.prototype.isAlive = function() {
    return !this.isDead();
}

Bomber.prototype.leavesBomb = function() {
    return new Bomb( this.where );
};

Bomber.prototype.throwsBomb = function( destination ) {
    return new Trayectory([this.where, destination]);
}

/***
 * @param   {Object}    dest    where it moves
 *
 */
Bomber.prototype.isIn = function stepsIn( here ) {
    return true;
};

module.exports = Bomber;

