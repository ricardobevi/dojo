const chai = require('chai');

const Calendar = require('../calendar');
const SingleDate = require('../single_date');

const Pacman = require('../pacman');
const Biscuit = require('../biscuit');
const Pellet = require('../pellet');

const Inky = require('../inky');

describe("pacman", () => {
    it("should get fat whether it eats biscuits", () => {
        var pacman = new Pacman();
        pacman.eat( new Biscuit() );

        chai.assert.equal(pacman.weight(), 1);
    });

    it("should get fat whether it eats biscuits", () => {
        var pacman = new Pacman();
        pacman.eat( new Biscuit() );
        pacman.eat( new Biscuit() );

        chai.assert.equal(pacman.weight(), 2);
    });

    it("should die whether bumps into phanton", () => {
        var pacman = new Pacman();
        var inky = new Inky();

        pacman.bumpsInto( inky );

        chai.assert.equal(pacman.isDead(), true);
        chai.assert.equal(pacman.isAlive(), false);

    });

    it("should weaken phantom whether it eats a pellet", () => {
        var pacman = new Pacman();
        var inky = new Inky();
        var pellet = new Pellet(inky);

        pacman.eat( pellet );

        var digestion = pacman.bumpsInto( inky );

        pacman.bumpsInto( digestion );

        chai.assert.equal(pacman.isDead(), false);
        chai.assert.equal(pacman.isAlive(), true);
    });

});
