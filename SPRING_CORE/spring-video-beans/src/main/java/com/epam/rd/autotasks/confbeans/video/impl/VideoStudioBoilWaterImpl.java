package com.epam.rd.autotasks.confbeans.video.impl;

import com.epam.rd.autotasks.confbeans.video.Video;
import com.epam.rd.autotasks.confbeans.video.VideoStudio;

import java.time.LocalDateTime;

public class VideoStudioBoilWaterImpl implements VideoStudio {

    @Override
    public Video produce() {
        LocalDateTime date = LocalDateTime.of(2020, 10, 10, 10, 10);
        String nameVideo = "How to boil water";
        return new Video(nameVideo, date);
    }

}
