package rentalshop;

import rentalshop.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BoardViewHandler {


    @Autowired
    private BoardRepository boardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBikeRented_then_CREATE_1 (@Payload BikeRented bikeRented) {
        try {
            if (bikeRented.isMe()) {
                // view 객체 생성
                Board board = new Board();
                // view 객체에 이벤트의 Value 를 set 함
                board.setRentId(bikeRented.getId());
                board.setBikeId(bikeRented.getBikeId());
                board.setBorrowerName(bikeRented.getBorrowerName());
                board.setStatus(bikeRented.getStatus());
                board.setBikeName(bikeRented.getBikeName());
                // view 레파지 토리에 save
                boardRepository.save(board);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenBikeReturned_then_UPDATE_1(@Payload BikeReturned bikeReturned) {
        try {
            if (bikeReturned.isMe()) {
                // view 객체 조회
                List<Board> boardList = boardRepository.findByRentId(bikeReturned.getId());
                for(Board board : boardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    board.setStatus(bikeReturned.getStatus());
                    board.setAmount(bikeReturned.getUseAmount());
                    // view 레파지 토리에 save
                    boardRepository.save(board);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCardSettled_then_UPDATE_2(@Payload CardSettled cardSettled) {
        try {
            if (cardSettled.isMe()) {
                // view 객체 조회
                List<Board> boardList = boardRepository.findByRentId(cardSettled.getRentId());
                for(Board board : boardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    board.setPaymentId(cardSettled.getId());
                    board.setPaymentResult(cardSettled.getResult());
                    board.setAmount(cardSettled.getChargeAmount());
                    // view 레파지 토리에 save
                    boardRepository.save(board);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}