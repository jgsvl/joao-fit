package com.joaofit.joaofit.dto;

import com.garmin.fit.DateTime;

public record FileId(Integer manufacturer, String name, Integer product, String productName,
                     DateTime timeCreated, Long serialNumber, Integer faveroProduct) {
}
