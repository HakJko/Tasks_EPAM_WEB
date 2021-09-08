package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import com.epam.rd.autotasks.confbeans.video.impl.VideoStudioBoilWaterImpl;
import com.epam.rd.autotasks.confbeans.video.impl.VideoStudioBuildHouseImpl;
import com.epam.rd.autotasks.confbeans.video.impl.VideoStudioEscapeSolitudeImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PrototypeChannelConfig {

    private static VideoStudioBoilWaterImpl boilWater = new VideoStudioBoilWaterImpl();
    private static VideoStudioBuildHouseImpl buildHouse = new VideoStudioBuildHouseImpl();
    private static VideoStudioEscapeSolitudeImpl escapeSolitude = new VideoStudioEscapeSolitudeImpl();

    @Bean
    @Scope("prototype")
    public Channel getBeanChanel() {
        Channel channelBean = new Channel();
        channelBean.addVideo(getBeanBoilWater());
        channelBean.addVideo(getBeanBuildHouse());
        channelBean.addVideo(getBeanEscapeSolitude());
        return channelBean;
    }

    @Bean("video1")
    public Video getBeanBoilWater() {
        return boilWater.produce();
    }

    @Bean
    public Video getBeanBuildHouse() {
        return buildHouse.produce();
    }

    @Bean
    public Video getBeanEscapeSolitude() {
        return escapeSolitude.produce();
    }

}
