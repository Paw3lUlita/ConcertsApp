package pl.coderslab.concertsapp.service;

import pl.coderslab.concertsapp.entity.Ask;
import pl.coderslab.concertsapp.entity.Club;

import java.util.List;

public interface AskService {

    List<Ask> findAsksByClub(Long clubId);

    void saveAsk(Ask ask);

    void deleteAskById(long askId);

    Ask findAskbyId(long askId);

}
