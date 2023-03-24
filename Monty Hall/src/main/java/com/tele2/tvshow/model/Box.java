package com.tele2.tvshow.model;

//Box object that represents each of the three boxes
public class Box {

        private boolean moneyBox;
        private boolean open;

        public Box() {
                this.moneyBox = false;
                this.open = false;
        }

        public void setMoneyBox(boolean value) {
                this.moneyBox = value;
        }

        public boolean isMoneyBox() {
                return moneyBox;
        }

        public void setOpen(boolean value) {
                this.open = value;
        }

        public boolean isOpen() {
                return open;
        }

}
