
package runtime;

import data.Brand;
import data.BrandList;
import data.CarList;
import ui.Menu;

public class CarManager {

    public static void main(String[] args) {
        BrandList bl = new BrandList();
        String brandUrl = "C:\\Users\\Admin\\Documents\\PIED-JAVA\\17.Van-pe-17-2-2022\\brands.txt";
        String carUrl = "C:\\Users\\Admin\\Documents\\PIED-JAVA\\17.Van-pe-17-2-2022\\cars.txt";
        bl.loadFromFile(brandUrl);
        CarList cl = new CarList(bl);
        cl.loadFromFile(carUrl);
        
        Menu menu = new Menu("Car Management System Menu");
        menu.addNewOption("List all brand");
        menu.addNewOption("Add a new brand");
        menu.addNewOption("Search a brand based on its ID");
        menu.addNewOption("Update a brand");
        menu.addNewOption("Save brands to the file , named brandsl.txt");
        menu.addNewOption("List all cars in ascending order of brand names");
        menu.addNewOption("List cars based on a part of an input brand name");
        menu.addNewOption("Add a car");
        menu.addNewOption("Remove a car based on its ID");
        menu.addNewOption("Update a car based on its ID");
        menu.addNewOption("Save cars to file , named cars.txt");
        
        while(true){
            menu.print();
            int choice = menu.getChoice();
            switch(choice){
                case 1:{
                    bl.listBrand();
                    break;
                }
                case 2:{
                    bl.addBrand();
                    break;
                }
                case 3:{
                    bl.searchBrand();
                    break;
                }
                case 4:{
                    bl.updateBrand();
                    break;
                }
                case 5:{
                    bl.saveToFile(brandUrl);
                    break;
                }
                case 6:{
                    cl.listCars();
                    break;
                }
                case 7:{
                    cl.printBaseBrandName();
                    break;
                }
                case 8:{
                    cl.addCar();
                    break;
                }
                case 9:{
                    cl.removeCar();
                    break;
                }
                case 10:{
                    cl.updateCar();
                    break;
                }
                case 11:{
                    cl.saveToFile(carUrl);
                    break;
                }

            }
        }
    }
    
}
