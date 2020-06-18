package rentalshop;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Board_table")
public class Board {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long rentId;
        private Long paymentId;
        private Long bikeId;
        private String borrowerName;
        private String bikeName;
        private String paymentResult;
        private String status;
        private Long amount;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getRentId() {
            return rentId;
        }

        public void setRentId(Long rentId) {
            this.rentId = rentId;
        }
        public Long getPaymentId() {
            return paymentId;
        }

        public void setPaymentId(Long paymentId) {
            this.paymentId = paymentId;
        }
        public Long getBikeId() {
            return bikeId;
        }

        public void setBikeId(Long bikeId) {
            this.bikeId = bikeId;
        }
        public String getBorrowerName() {
            return borrowerName;
        }

        public void setBorrowerName(String borrowerName) {
            this.borrowerName = borrowerName;
        }
        public String getBikeName() {
            return bikeName;
        }

        public void setBikeName(String bikeName) {
            this.bikeName = bikeName;
        }
        public String getPaymentResult() {
            return paymentResult;
        }

        public void setPaymentResult(String paymentResult) {
            this.paymentResult = paymentResult;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }

}
