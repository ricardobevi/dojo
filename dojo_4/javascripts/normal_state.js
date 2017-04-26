function NormalState() {
};

NormalState.prototype.collide = function(aPacman, aPhantom) {
    aPacman.die();
};

module.exports = NormalState;

