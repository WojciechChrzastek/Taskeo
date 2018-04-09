package com.crud.tasks.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TrelloMapperTest {
    private TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void mapToBoards() {
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("id1", "name1", new ArrayList<>());
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);
        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        assertEquals(1, trelloBoardList.size());
        assertEquals("id1", trelloBoardList.get(0).getId());
        assertEquals("name1", trelloBoardList.get(0).getName());
        assertEquals(new ArrayList<>(), trelloBoardList.get(0).getLists());
    }

    @Test
    public void mapToBoardsDto() {
        //Given
        TrelloBoard trelloBoard = new TrelloBoard("id2", "name2", new ArrayList<>());
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);
        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoards);
        //Then
        assertEquals(1, trelloBoardDtoList.size());
        assertEquals("id2", trelloBoardDtoList.get(0).getId());
        assertEquals("name2", trelloBoardDtoList.get(0).getName());
        assertEquals(new ArrayList<>(), trelloBoardDtoList.get(0).getLists());
    }

    @Test
    public void mapToList() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("id3", "name3", true);
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        trelloListDtoList.add(trelloListDto);
        //When
        List<TrelloList> trelloListList = trelloMapper.mapToList(trelloListDtoList);
        //Then
        assertEquals(1, trelloListList.size());
        assertEquals("id3", trelloListList.get(0).getId());
        assertEquals("name3", trelloListList.get(0).getName());
        assertTrue(trelloListList.get(0).isClosed());
    }

    @Test
    public void mapToListDto() {
        //Given
        TrelloList trelloList = new TrelloList("id4", "name4", true);
        List<TrelloList> trelloListList = new ArrayList<>();
        trelloListList.add(trelloList);
        //When
        List<TrelloListDto> trelloListDtoList = trelloMapper.mapToListDto(trelloListList);
        //Then
        assertEquals(1, trelloListDtoList.size());
        assertEquals("id4", trelloListDtoList.get(0).getId());
        assertEquals("name4", trelloListDtoList.get(0).getName());
        assertTrue(trelloListDtoList.get(0).isClosed());
    }

    @Test
    public void mapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("card1", "desc1", "pos1", "listId1");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("card1", trelloCardDto.getName());
        assertEquals("desc1", trelloCardDto.getDescription());
        assertEquals("pos1", trelloCardDto.getPos());
        assertEquals("listId1", trelloCardDto.getListId());
    }

    @Test
    public void mapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card2", "desc2", "pos2", "listId2");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("card2", trelloCard.getName());
        assertEquals("desc2", trelloCard.getDescription());
        assertEquals("pos2", trelloCard.getPos());
        assertEquals("listId2", trelloCard.getListId());
    }
}
