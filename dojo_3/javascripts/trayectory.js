var Bomb = require('./bomb');

function Trayectory(_steps) {
    this.steps = _steps;
    this.bomb = new Bomb();
};

Trayectory.prototype.swishs = function() {
    this.steps = this.steps.slice(1);
    return this.bomb.ticks();
}

module.exports = Trayectory;

