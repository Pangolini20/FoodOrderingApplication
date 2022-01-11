import {Component, Input} from '@angular/core';
import {Category} from "../../Models/category.model";
import {Router} from "@angular/router";
import {Foodcategory} from "../../dto/foodcategory";

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
    console.log("hello?")
    console.log(this.item)

    this.router.navigateByUrl('/category',{ state: { data: this.chooseFoodCateg() } });
  }

  chooseFoodCateg():Foodcategory
  {
    switch (this.item.label)
    {
      case 'Burgers': return Foodcategory.BURGERS
        break;
      case 'Sweets': return Foodcategory.SWEETS
        break;
      case 'Pizza': return Foodcategory.PIZZA
        break;
      case  'Drinks': return Foodcategory.DRINKS
        break;
    }
  }

}
