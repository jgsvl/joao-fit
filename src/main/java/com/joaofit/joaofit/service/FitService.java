package com.joaofit.joaofit.service;

import com.garmin.fit.Decode;
import com.garmin.fit.MesgBroadcaster;
import com.garmin.fit.RecordMesgListener;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class FitService {

    public List<String> lerArquivoFit(MultipartFile file) {
        List<String> registros = new ArrayList<>();
        InputStream is;
        try {
            is = file.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Decode verifica a integridade do arquivo .fit
        Decode decoder = new Decode();
        MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decoder);
        // Listener para mensagens de "Record" (cada ponto de GPS/batimento)
        mesgBroadcaster.addListener((RecordMesgListener) mesg -> {
            String dado = String.format("Tempo: %s | Lat: %f | Long: %f | Alt: %.2fm | Freq Cardiaca: %s | Cadência: %s",
                    mesg.getTimestamp(),
                    mesg.getPositionLat() != null ? mesg.getPositionLat() * (180.0 / Math.pow(2, 31)) : 0,
                    mesg.getPositionLong() != null ? mesg.getPositionLong() * (180.0 / Math.pow(2, 31)) : 0,
                    mesg.getAltitude(),
                    mesg.getHeartRate(),
                    mesg.getCadence());
            registros.add(dado);
        });

        mesgBroadcaster.run(is);
        return registros;

    }

}
