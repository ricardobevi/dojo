function Cell( _habitant ) {
    this.habitant = _habitant;
};

Cell.prototype.releasesBy = function releasesBy( something ) {
    this.habitant = null;
};

Cell.prototype.reclaimsBy = function reclaimsBy( something ) {
    if ( this.habitant ) {
        throw new Error();
    };

    this.habitant = something;
};

module.exports = Cell;

