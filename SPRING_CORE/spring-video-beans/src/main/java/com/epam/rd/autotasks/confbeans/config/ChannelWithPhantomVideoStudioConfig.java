package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
public class ChannelWithPhantomVideoStudioConfig {

    private static final String FRANCHISE = "Cat & Curious ";
    private static final int NUMBER_FILMS_FRANCHISE = 8;
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
    @Scope("prototype")
    public Video beanVideo() {
        return getMovieFranchise();
    }
}
