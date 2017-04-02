var Nobody = require('./nobody');

function Cell( _habitant ) {
    this.habitant = _habitant || new Nobody();
};

Cell.prototype.releasedBy = function releasesBy( something ) {
    this.habitant = new Nobody();
};

Cell.prototype.reclaimedBy = function reclaimsBy( something ) {
    this.habitant = this.habitant.bumpsInto(something);
};

Cell.prototype.isEmpty = function() {
    return this.habitant.isEqual( new Nobody() );
}

Cell.prototype.asArray = function() {
    return [this];
}

module.exports = Cell;

