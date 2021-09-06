package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Configuration
public class ChannelWithInjectedPrototypeVideoConfig extends Channel {

    private static final String NAME_VIDEO = "Cat Failure Compilation";
    private static LocalDateTime release = LocalDateTime.of(2001, 10, 18, 10, 0);

    @Override
    public Stream<Video> videos() {
        Channel localChannel = new Channel();
        int day = 1;
        int lastDay = 7;
        while (day <= lastDay) {
            localChannel.addVideo(getVideo());
            day++;
        }
        return localChannel.videos();
    }

    private Video getVideo() {
        Video video = new Video(NAME_VIDEO, release);
        updateRelease();
        return video;
    }

    private void updateRelease() {
        final long step = 1;
        release = release.plusDays(step);
    }

    @Bean("channel")
    public Channel getBeanChanel() {
        return new ChannelWithInjectedPrototypeVideoConfig();
    }

    @Bean
    @Scope("prototype")
    public Video getBeanVideo() {
        return getVideo();
    }


}
