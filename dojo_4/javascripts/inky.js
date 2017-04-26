const NormalState = require('./normal_state');
const WeakenedState = require('./weakened_state');
const ZombieState = require('./zombie_state');

function Inky() {
    this.food = [];
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

