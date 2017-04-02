function Explosion( _epicenter ) { 
    this.epicenter = _epicenter;
};

Explosion.prototype.damages = function( cellsContent ) {
    cellsContent = cellsContent.asArray();
    cellsContent.forEach( c => c.releasedBy() );
};

module.exports = Explosion;

