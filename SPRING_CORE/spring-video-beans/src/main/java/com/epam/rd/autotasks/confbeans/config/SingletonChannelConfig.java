package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class SingletonChannelConfig {

    @Bean
    public Channel getBeanChanel() {
        Channel channelBean = new Channel();
        channelBean.addVideo(getBeanBoilWater());
        channelBean.addVideo(getBeanBuildHouse());
        channelBean.addVideo(getBeanEscapeSolitude());
        return channelBean;
    }

    @Bean("video1")
    public Video getBeanBoilWater() {
        LocalDateTime date = LocalDateTime.of(2020, 10, 10, 10, 10);
        String nameVideo = "How to boil water";
        return new Video(nameVideo, date);
    }

    @Bean
    public Video getBeanBuildHouse() {
        LocalDateTime date = LocalDateTime.of(2020, 10, 10, 10, 11);
        String nameVideo = "How to build a house";
        return new Video(nameVideo, date);
    }

    @Bean
    public Video getBeanEscapeSolitude() {
        LocalDateTime date = LocalDateTime.of(2020, 10, 10, 10, 12);
        String nameVideo = "How to escape solitude";
        return new Video(nameVideo, date);
    }


}
