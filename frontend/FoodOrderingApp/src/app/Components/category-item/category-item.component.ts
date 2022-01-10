import {Component, Input, OnInit} from '@angular/core';
import {Category} from "../../Models/category.model";
import{Router} from "@angular/router";

@Component({
  selector: 'app-category-item',
  templateUrl: './category-item.component.html',
  styleUrls: ['./category-item.component.scss'],
})
export class CategoryItemComponent {
  @Input() item: Category;

  constructor(private router:Router) {
  }
  goToCategory(){
    this.router.navigateByUrl('/category');
  }

}
