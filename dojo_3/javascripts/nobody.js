function Nobody() { };

Nobody.prototype.bumpsInto = function bumpsInto( anCharacterOrObject ) {
    return anCharacterOrObject;
};

Nobody.prototype.isEqual = function() {
    return true;
}

module.exports = Nobody;

