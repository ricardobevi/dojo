const chai = require('chai');

const Bomber = require('../bomber');
const Bagulaa = require('../bagulaa');
const Cell = require('../cell');
const Brick = require('../brick');


describe("bomberman", () => {
    describe("bomberman", () => {
        it("steps into a cell which is empty then it moves in", () => {
            var bornPlace = new Cell();
            var bomber = new Bomber( bornPlace );
            var here = new Cell();
            bomber.stepsIn( here );
            chai.assert.equal( bomber.isIn(here), true);

        });

        it("steps into a cell which is busy with an object then it doesn't move and throw an exception", () => {
            var bornPlace = new Cell();
            var bomber = new Bomber( bornPlace );
            var here = new Cell( new Brick() );
            chai.assert.throws( () => {
                bomber.stepsIn( here );
            });
        });

        it("steps into a cell which is busy with an enemy then it dies", () => {
            var bomber = new Bomber( new Cell() );
            var here = new Cell( new Bagulaa() );
            bomber.stepsIn( here );
            chai.assert.equal( bomber.isDead(), true);
            chai.assert.equal( bomber.isAlive(), false);
        });

        it("leaves a boom next to a brick, the boom explotes and the bricks disappears", () => {
            var bomber = new Bomber( new Cell() );
            var cellWithBrick = new Cell( new Brick() );


            var bomb = bomber.leavesBomb();
            bomb.ticks();
            var explotion = bomb.ticks();
            explotion.damages(cellWithBrick);

            chai.assert.isTrue( cellWithBrick.isEmpty() );

        });

        it("throws a boom to a brick, the boom explotes and the bricks disappears", () => {
            var bomber = new Bomber( new Cell() );
            var cellWithBrick = new Cell( new Brick() );

            var trayectory = bomber.throwsBomb( cellWithBrick );
            trayectory.swishs();
            var explotion = trayectory.swishs();

            explotion.damages(cellWithBrick);

            chai.assert.isTrue( cellWithBrick.isEmpty() );
        });
    });

});
