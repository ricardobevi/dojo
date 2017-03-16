function Bomber( bornPlace) {
    this.where = bornPlace;
};

/***
 * @param   {Object}    dest    where it moves
 *
 */
Bomber.prototype.stepsIn = function stepsIn( place ) {
    this.stepsOut( this.where );
    place.reclaimsBy(this);
    this.where = place;
    return this;
};

Bomber.prototype.stepsOut = function stepsOut( place ) {
    place.releasesBy(this);
}

/***
 * @param   {Object}    dest    where it moves
 *
 */
Bomber.prototype.isIn = function stepsIn( here ) {
    return true;
};

module.exports = Bomber;

