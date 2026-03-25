package com.joaofit.joaofit.dto;

import java.util.List;

public record Activity(List<FileId> fileIds, List<DeviceInfo> deviceInfos, List<Session> sessions) {

}
