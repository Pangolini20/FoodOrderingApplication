import {FoodDto} from "./food-dto";

export class Orderdto {
  id:number;
  receiverId:number;
  deliveryUserId:number;
  restaurantId:number;
  date:string;
  foodDtoList:FoodDto[] =[];

}
