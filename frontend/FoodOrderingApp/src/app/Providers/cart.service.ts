import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class CartService {

  private data = [
    {
      category: 'Burgers',
      expanded: true,
      products: [
        { id: 4, name: 'Mac & Cheese', price: '8' },
        { id: 5, name: 'Bolognese', price: '6' }
      ]
    },
    {
      category: 'Pizza',
      expanded: true,
      products: [
        { id: 0, name: 'Salami', price: '8' },
        { id: 1, name: 'Classic', price: '5' },
        { id: 2, name: 'Tuna', price: '9' },
        { id: 3, name: 'Hawai', price: '7' }
      ]
    },
    {
      category: 'Sweets',
      expanded: true,
      products: [
        { id: 4, name: 'Oreo Ice-cream', price: '8' },
        { id: 5, name: 'Choco', price: '6' }
      ]
    },
    {
      category: 'Drinks',
      expanded: true,
      products: [
        { id: 6, name: 'Coke', price: '8' },
        { id: 7, name: 'Pepsi', price: '5' },
        { id: 8, name: 'Limo', price: '9' }
      ]
    }
  ];

  private cart = [];

  constructor() { }

  getProducts() {
    return this.data;
  }

  getCart() {
    return this.cart;
  }

  addProduct(product) {
    this.cart.push(product);
  }

}
