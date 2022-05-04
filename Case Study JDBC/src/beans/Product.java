package beans;

public class Product {
        private int outlet_number;
        private int product_code;
        private String artist;
        private String title;
        private int cost;
        private int sale_price;

        public int getOutlet_number() {return outlet_number;}

        public void setOutlet_number(int outlet_number) {this.outlet_number = outlet_number; }

        public int getProduct_code() {
            return product_code;
        }

        public void setProduct_code(int product_code) {
            this.product_code = product_code;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getSale_price() {
            return sale_price;
        }

        public void setSale_price(int sale_price) {
            this.sale_price = sale_price;
        }

}//Product
