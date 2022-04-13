package edu.hanu.sqaproject.service;

import edu.hanu.sqaproject.model.ReserveSeatConfiguration;
import org.springframework.ui.Model;

import java.security.Principal;

public interface ReservationService {

    String showMovieReservationPage(final String movieName, final Model model);

    String showMovieReservationSeatPage(final String movieName, final Long repertoireId, final Model model);

    String reservation(final ReserveSeatConfiguration reserveSeatConfiguration, final Long repertoireId, final Principal principal);
}