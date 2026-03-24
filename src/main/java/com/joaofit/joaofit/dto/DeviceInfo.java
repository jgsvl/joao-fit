package com.joaofit.joaofit.dto;

public record DeviceInfo(Short deviceType, Integer manufacturer,
                         String name, Short antplusDeviceType, Short bleDeviceType, String descriptor) {
}
