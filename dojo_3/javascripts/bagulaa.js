function Bagulaa( bornPlace) {
    this.where = bornPlace;
};

Bagulaa.prototype.bumpsInto = function bumpsInto( anCharacterOrObject ) {
    return anCharacterOrObject.bumpsIntoBagulaa(this);
};

module.exports = Bagulaa;

