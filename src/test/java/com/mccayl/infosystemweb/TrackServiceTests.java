package com.mccayl.infosystemweb;

import com.mccayl.infosystemweb.model.Track;
import com.mccayl.infosystemweb.repository.TrackRepository;
import com.mccayl.infosystemweb.service.impl.TrackServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class TrackServiceTests {

    @Mock
    private TrackRepository trackRepository;

    @InjectMocks
    private TrackServiceImpl trackService;

    private Track track;

    @BeforeEach
    public void setUp() {
        track = new Track();
        track.setId(1L);
        track.setName("test");
        track.setAuthor("test");
        track.setGenre("test");
        track.setLength(1);
    }

    @DisplayName("test for addTrack method")
    @Test
    public void givenTrackObject_whenAddTrack_thenReturnTrackObject() {
        given(trackRepository.findById(track.getId()))
                .willReturn(Optional.empty());
        System.out.println(trackRepository.findById(track.getId()));

        given(trackRepository.saveAndFlush(track))
                .willReturn(track);

        Track savedTrack = trackService.addTrack(track);

        assertThat(savedTrack).isNotNull();
    }

}
