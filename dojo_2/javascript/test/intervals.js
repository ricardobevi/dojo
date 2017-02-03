const chai = require('chai');
const CellAddress = require('../cellAddress');

var sheet;

describe("Intervals", () => {
    describe("succ", () => {
        var a1 = new CellAddress("a", 1);
        var b1 = a1.hSucc();

        chai.expect( b1.isEqual( new CellAddress("b", 1) ) ).to.be.true;
    });

    describe("succ", () => {
        var a1 = "a1".asCellAddress();
        var a2 = a1.vSucc();

        chai.expect( a2.isEqual( "a2".asCellAddress() ) ).to.be.true;
    });

    describe("vertical range", () => {
        it("should return a list of cellAddress", () => {
            var a1 = new CellAddress("a", 1);
            var a9 = new CellAddress("a", 9);
            var range = a1.to( a9 );

            chai.expect( range[0].isEqual( "a1".asCellAddress() ) ).to.be.true;
            chai.expect( range[1].isEqual( "a2".asCellAddress() ) ).to.be.true;
            chai.expect( range[2].isEqual( "a3".asCellAddress() ) ).to.be.true;
            chai.expect( range[8].isEqual( "a9".asCellAddress() ) ).to.be.true;
        });
    });

});

