package com.inventory.leonardo.inventory;

import com.inventory.leonardo.inventory.model.Items;
import com.inventory.leonardo.inventory.service.ItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemsResource {
    private final ItemsService itemsService;

    public ItemsResource(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    // per vedere tutti
    @GetMapping("/all")
    public ResponseEntity<List<Items>> getAllItems () {
        List<Items> allItems = itemsService.findAllItems();
        return new ResponseEntity<>(allItems, HttpStatus.OK);
    }

    // per cercare by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Items> getItemsById (@PathVariable("id") Integer id) {
        Items items = itemsService.findItemById(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // per creare nuovo item
    @PostMapping("/add")
    public ResponseEntity<Items> addItem(@RequestBody Items item) {
        Items newItem = itemsService.addItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    // per aggiornare item
    @PutMapping("/update")
    public ResponseEntity<Items> updateItem(@RequestBody Items item) {
        Items updateItem = itemsService.updateItems(item);
        return new ResponseEntity<>(updateItem, HttpStatus.OK);
    }

    //per cancellare gli item
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") Integer id) {
        itemsService.deleteItems(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
