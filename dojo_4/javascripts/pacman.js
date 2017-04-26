function Pacman() {
    this.food = [];
    this.alive = true;
};

Pacman.prototype.eat = function(aBiscuitOrPellet) {
    this.food.push(aBiscuitOrPellet);
    aBiscuitOrPellet.eaten(this);
}

Pacman.prototype.weight = function() {
    return this.food.length;
}

Pacman.prototype.bumpsInto = function(aPhantom) {
    return aPhantom.bumpsInto(this);
};

Pacman.prototype.swallow = function(aPhantom) {
    aPhantom.swallowedBy(this);
    return aPhantom;
};

Pacman.prototype.die = function() {
    this.alive = false;
};

Pacman.prototype.isAlive = function() {
    return this.alive;
};

Pacman.prototype.isDead = function() {
    return !this.isAlive();
};

module.exports = Pacman;

