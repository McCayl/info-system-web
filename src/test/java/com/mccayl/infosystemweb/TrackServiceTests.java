package com.mccayl.infosystemweb;

import com.mccayl.infosystemweb.exception.TrackNotFoundException;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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

    @DisplayName("test for getById method")
    @Test
    public void getByIdGetNonExistentTrackException() {
        assertThrows(TrackNotFoundException.class,
                () -> trackService.getById(track.getId()));
    }

    @DisplayName("test for addTrack method")
    @Test
    public void addTrackWillReturnTrackTrackObject() {
        when(trackRepository.saveAndFlush(any(Track.class))).then(returnsFirstArg());
        Track savedTrack = trackService.addTrack(track);

        assertThat(savedTrack).isEqualTo(track);
    }
}
