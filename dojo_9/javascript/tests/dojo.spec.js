import { expect, assert } from 'chai';

import Dojo from '../src/Dojo';

describe('#Dojo', () => {
  describe('sensei', () => {
    it('should return the current sensei of the dojo', () => {
      const dojo = new Dojo({ sensei: 'david' });

      expect(dojo.sensei).to.be.equal('david');
    });

    it('should return the default sensei of the dojo', () => {
      const dojo = new Dojo();

      expect(dojo.sensei).to.be.equal('diego');
    });

    it('it should be both equal', () => {
      const anInstanceOfDojo = new Dojo();
      const anotherInstanceOfDojo = new Dojo();

      assert.equal(anInstanceOfDojo.isEqual(anotherInstanceOfDojo), true);
    });

    it('it shoud throw exception', () => {
      const dojo = new Dojo();

      assert.throws(() => {
        dojo.explode();
      });
    });
  });
});
