class Dojo {
  constructor({ sensei = 'diego' } = {}) {
    this.sensei = sensei;
  }

  isEqual(instance) {
    return this.sensei === instance.sensei;
  }

  explode() {
    throw new Error('💥');
  }
}

export default Dojo;