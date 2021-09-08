package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import com.epam.rd.autotasks.confbeans.video.VideoStudio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Configuration
public class ChannelWithVideoStudioConfig {

    public static final String FRANCHISE = "Cat & Curious ";
    public static final int NUMBER_FILMS_FRANCHISE = 8;
    private static int episode = 1;
    private static LocalDateTime release = LocalDateTime.of(2001, 10, 18, 10, 0);
    private static Channel channelBean = new Channel();

    @Bean
    public Channel getBeanChanel() {
        while (episode <= NUMBER_FILMS_FRANCHISE) {
            channelBean.addVideo(getMovieFranchise());
        }
        return channelBean;
    }

    private Video getMovieFranchise() {
        Video movie = new Video(FRANCHISE + episode, release);
        updateRelease();
        return movie;
    }

    private void updateRelease() {
        final long step = 2;
        episode++;
        release = release.plusYears(step);
    }

    @Bean
    public VideoStudio beanVideoStudio() {
        final VideoStudio videoStudio = () -> {
            channelBean.addVideo(getMovieFranchise());
            return channelBean.videos()
                    .collect(Collectors.toList())
                    .get(episode - 2);
        };
        return videoStudio;
    }


}
