function WakenedState() {
};

WakenedState.prototype.collide = function(aPacman, aPhantom) {
    return aPacman.swallow( aPhantom );
};

module.exports = WakenedState;

