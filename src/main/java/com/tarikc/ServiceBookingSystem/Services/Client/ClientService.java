package com.tarikc.ServiceBookingSystem.Services.Client;

import com.tarikc.ServiceBookingSystem.Dto.*;

import java.util.List;

public interface ClientService {
    List<AdDto> getAllAds();
    List<AdDto> SearchAdByName(String name);
    boolean bookService(ReservationDto reservationDto);
    AdDetailsForClientDto getAdDetailsByAdId(Long adId);
    List<ReservationDto> getAllBookingsByUserId(Long userId);
    Boolean giveReview(ReviewDto reviewDto);
    UserDto updateUserProfile(Long userId, UserDto userDto);
}
