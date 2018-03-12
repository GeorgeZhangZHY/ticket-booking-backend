package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.model.CouponType;
import edu.nju.ticketbooking.service.CouponTypeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CouponTypeController {

    @Autowired
    private CouponTypeServ couponTypeServ;

    @GetMapping(value = "/couponType")
    public List<CouponType> getCouponTypeList(@RequestParam(value = "activatedOnly", defaultValue = "false") boolean activatedOnly) {
        return couponTypeServ.getCouponTypeList(activatedOnly);
    }

    @PostMapping(value = "/couponType")
    public CouponType addNewCouponType(@RequestBody CouponType newCouponType) {
        return couponTypeServ.addNewCouponType(newCouponType);
    }

    @PutMapping(value = "/couponType")
    public CouponType modifyCouponType(@RequestBody CouponType modifiedCouponType) {
        return couponTypeServ.modifyCouponType(modifiedCouponType);
    }

    @PutMapping(value = "/couponType/activate")
    public boolean setCouponTypeActivated(
            @RequestParam(value = "couponTypeId") int couponTypeId,
            @RequestParam(value = "isActivated") boolean isActivated
    ) {
        couponTypeServ.setCouponTypeActivated(couponTypeId, isActivated);
        return isActivated;
    }
}
