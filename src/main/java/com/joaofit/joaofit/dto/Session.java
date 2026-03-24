package com.joaofit.joaofit.dto;

import com.garmin.fit.DateTime;
import com.garmin.fit.Sport;
import com.garmin.fit.SubSport;

public record Session(DateTime startTime, Sport sport, SubSport subSport, Float totalElapsedTime, Float avgSpeed,
                      Short avgHeartRate, Short avgCadence) {
}
