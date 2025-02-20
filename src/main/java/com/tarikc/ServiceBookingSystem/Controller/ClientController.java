package com.tarikc.ServiceBookingSystem.Controller;


import com.tarikc.ServiceBookingSystem.Dto.ReservationDto;
import com.tarikc.ServiceBookingSystem.Dto.ReviewDto;
import com.tarikc.ServiceBookingSystem.Dto.UserDto;
import com.tarikc.ServiceBookingSystem.Services.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/ads")
    public ResponseEntity<?> getAllAds(){
        return ResponseEntity.ok(clientService.getAllAds());
    }
    @GetMapping("/search/{name}")
    public  ResponseEntity<?> searchAdByService(@PathVariable String name){
        return  ResponseEntity.ok(clientService.SearchAdByName(name));
    }
    @PostMapping("/book-service")
    public ResponseEntity<?> bookService(@RequestBody ReservationDto reservationDto){
        boolean success = clientService.bookService(reservationDto);
        if(success){
            return  ResponseEntity.status(HttpStatus.OK).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
   }
   @GetMapping("/ad/{adId}")
   public ResponseEntity<?> getAdDetailsByAdId(@PathVariable Long adId){
        return ResponseEntity.ok(clientService.getAdDetailsByAdId(adId));
   }

   @GetMapping("/my-bookings/{userId}")
   public  ResponseEntity<?> getAllBookingsByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(clientService.getAllBookingsByUserId(userId));
   }

   @PostMapping("/review")
   public ResponseEntity<?> giveReview(@RequestBody ReviewDto reviewDto){
        Boolean success = clientService.giveReview(reviewDto);
        if(success){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
   }
    @PutMapping("/update-profile/{userId}")
    public ResponseEntity<?> updateUserProfile(@PathVariable Long userId, @RequestBody UserDto userDto) {
        UserDto updatedUser = clientService.updateUserProfile(userId, userDto);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }




}
