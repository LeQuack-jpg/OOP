package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CheckoutPanel extends JPanel {

    public CheckoutPanel() {
        setLayout(new BorderLayout());

        // Tiêu đề phòng
        JLabel titleLabel = new JLabel("Phòng 110 | Giá phòng: 450,000", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.RED);
        add(titleLabel, BorderLayout.NORTH);

        // Panel chính
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(createBookingInfoPanel(), BorderLayout.NORTH);
        centerPanel.add(createDetailSectionPanel(), BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);
        add(createFooterPanel(), BorderLayout.SOUTH);
    }

    // Thông tin đặt phòng (Booking)
    private JPanel createBookingInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 4, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Thông Tin Đặt Phòng (Booking)"));

        panel.add(new JLabel("Khách hàng (Customer):"));
        panel.add(new JTextField("Nguyễn Văn A"));
        panel.add(new JLabel("Loại thuê (Booking Type):"));
        panel.add(new JComboBox<>(new String[]{"Theo ngày", "Theo giờ"}));

        panel.add(new JLabel("Nhân viên (Employee):"));
        panel.add(new JTextField("Lê Tuấn Anh"));
        panel.add(new JLabel("Số người ở:"));
        panel.add(new JTextField("2"));

        panel.add(new JLabel("Mã hóa đơn (Invoice ID):"));
        panel.add(new JTextField("HD017"));
        panel.add(new JLabel("Tên phòng (Room):"));
        panel.add(new JTextField("Phòng 110"));

        return panel;
    }

    // Chi tiết dịch vụ, thiết bị, phụ thu, tổng tiền
    private JPanel createDetailSectionPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));

        panel.add(createServiceUsagePanel());
        panel.add(createEquipmentUsagePanel());
        panel.add(createSurchargePanel());
        panel.add(createInvoiceSummaryPanel());

        return panel;
    }

    // Dịch vụ sử dụng (ServiceUsage)
    private JPanel createServiceUsagePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Chi Tiết Dịch Vụ (Service Usage)"));

        JTable table = new JTable(new String[][]{
                {"DV001", "Giặt ủi", "100000", "1"},
                {"DV002", "Dịch vụ bar", "250000", "2"}
        }, new String[]{"Mã DV", "Tên DV", "Giá", "Số lượng"});

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    // Thiết bị sử dụng (EquipmentUsage)
    private JPanel createEquipmentUsagePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Chi Tiết Thiết Bị (Equipment Usage)"));

        JTable table = new JTable(new String[][]{
                {"TB001", "Tivi", "500000", "1"},
                {"TB002", "Bàn ủi", "1000000", "1"}
        }, new String[]{"Mã TB", "Tên TB", "Giá", "Số lượng"});

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    // Phụ thu check-in/check-out
    private JPanel createSurchargePanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Phụ Thu Check-in/Check-out"));

        panel.add(new JLabel("Tiền đặt cọc (Deposit):"));
        panel.add(new JTextField("1,012,500"));

        panel.add(new JLabel("Phụ thu Check-in:"));
        panel.add(new JTextField("0"));

        panel.add(new JLabel("Phụ thu Check-out:"));
        panel.add(new JTextField("225,000"));

        panel.add(new JLabel("Tổng phụ thu (Total Surcharge):"));
        panel.add(new JTextField("225,000"));

        panel.add(new JLabel("Tổng thanh toán tạm thời:"));
        panel.add(new JTextField("1,575,000"));

        return panel;
    }

    // Tổng tiền - tương ứng với Invoice
    private JPanel createInvoiceSummaryPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Tổng Thanh Toán (Invoice Summary)"));

        panel.add(new JLabel("Tổng tiền dịch vụ (Service Total):"));
        JTextField serviceTotalField = new JTextField("600,000");
        serviceTotalField.setName("serviceTotal");
        panel.add(serviceTotalField);

        panel.add(new JLabel("Tổng tiền thiết bị (Equipment Total):"));
        JTextField equipmentTotalField = new JTextField("150,000");
        equipmentTotalField.setName("equipmentTotal");
        panel.add(equipmentTotalField);

        panel.add(new JLabel("Tổng thanh toán (Final Amount):"));
        JTextField finalAmountField = new JTextField("1,177,500 VNĐ");
        finalAmountField.setName("finalAmount");
        finalAmountField.setForeground(Color.RED);
        panel.add(finalAmountField);

        panel.add(new JLabel("Tiền khách đưa (Customer Paid):"));
        JTextField paidField = new JTextField("2,000,000");
        paidField.setName("customerPaid");
        panel.add(paidField);

        panel.add(new JLabel("Tiền trả lại (Change):"));
        JTextField changeField = new JTextField("822,500 VNĐ");
        changeField.setName("changeAmount");
        changeField.setForeground(Color.BLUE);
        panel.add(changeField);

        return panel;
    }

    // Footer với các nút hành động
    private JPanel createFooterPanel() {
        JPanel panel = new JPanel();

        JButton btnCheckout = new JButton("Check-out");
        JButton btnPrintInvoice = new JButton("In Hóa Đơn");
        JButton btnBack = new JButton("Quay lại");

        panel.add(btnCheckout);
        panel.add(btnPrintInvoice);
        panel.add(btnBack);

        return panel;
    }

    // Khởi chạy JFrame để hiển thị
    public static void main(String[] args) {
        JFrame frame = new JFrame("Thanh Toán - Checkout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CheckoutPanel());
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
