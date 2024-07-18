package duermes.gui;

import duermes.Empresa;
import duermes.Status;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.InputStream;

public class MainFrame extends JFrame {

    JPanel newEmployeePanel, employeePanel, informationPanel, editEmployeePanel, billingPanel;
    JButton closeBtn, newEmployeeBtn, employeeBtn, informationBtn, addBtn1, employeeBtn2, billingBtn, editBtn,
            queueBtn, stackBtn;
    JTextField nameTxt, lastNameTxt, birthDateTxt, monthlyRateTxt, workedDaysTxt;
    JTextArea importeTotalTxt;
    Font actorFont;
    JComboBox<Status> status1, status2;
    JComboBox<String> orderBy, searchBy;
    JTable billingPaymentTable, employeeTable;
    DefaultTableModel billingModel, employeeModel;


    public MainFrame() {
        super("Control de Planilla ATE");
        setSize(1241, 702);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(0,0,0));
        ImageIcon icon = new ImageIcon(getClass().getResource("/app_icon.png"));
        setIconImage(icon.getImage());
        fontSetup();
        panels();
        menu();
        actionListeners();
        setVisible(true);

    }

    public void panels() {
        newEmployeePanel = new JPanel();
        newEmployeePanel.setBounds(296, 32, 905, 609);
        newEmployeePanel.setLayout(null);
        newEmployeePanel.setBackground(new Color(242, 213, 195));

        // NEW EMPLOYEE
        JLabel titleLabel1 = new JLabel("NUEVO PERSONAL");
        titleLabel1.setFont(actorFont.deriveFont(24f));
        titleLabel1.setBounds(374, 94, 296, 44);
        titleLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        titleLabel1.setForeground(new Color(191, 111, 31));

        JLabel nameLabel1 = new JLabel("NOMBRES:");
        nameLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        nameLabel1.setBounds(129, 189, 172, 35);
        nameTxt = new JTextField();
        nameTxt.setBounds(322, 189, 433, 30);
        nameTxt.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JLabel lastNameLabel1 = new JLabel("APELLIDOS:");
        lastNameLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        lastNameLabel1.setBounds(129, 225, 172, 35);
        lastNameTxt = new JTextField();
        lastNameTxt.setBounds(322, 225, 433, 30);
        lastNameTxt.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JLabel birthDateLabel1 = new JLabel("FECHA DE NACIMIENTO:");
        birthDateLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        birthDateLabel1.setBounds(129, 264, 172, 35);
        birthDateTxt = new JTextField();
        birthDateTxt.setBounds(322, 264, 433, 30);
        birthDateTxt.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JLabel salaryLabel1 = new JLabel("TARIFA MENSUAL:");
        salaryLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        salaryLabel1.setBounds(129, 300, 172, 35);
        monthlyRateTxt = new JTextField();
        monthlyRateTxt.setBounds(322, 300, 433, 30);
        monthlyRateTxt.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JLabel daysWorkedInAMonth = new JLabel("DIAS AL MES TRABAJADOS:");
        daysWorkedInAMonth.setHorizontalAlignment(SwingConstants.LEFT);
        daysWorkedInAMonth.setBounds(129, 338, 172, 35);
        workedDaysTxt = new JTextField();
        workedDaysTxt.setBounds(322, 338, 433, 30);
        workedDaysTxt.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));


        JLabel statusLabel1 = new JLabel("ESTADO DEL TRABAJOR:");
        statusLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        statusLabel1.setBounds(129, 383, 172, 35);
        status1 = new JComboBox<>(Status.values());
        status1.setBounds(322, 383, 433, 30);
        status1.setBackground(new Color(221, 140, 88));
        status1.setBorder(BorderFactory.createEmptyBorder());
        status1.setFocusable(false);


        addBtn1 = new JButton("AGREGAR");
        addBtn1.setBounds(322, 452, 172, 35);
        addBtn1.setBackground(new Color(221, 140, 88));
        addBtn1.setFocusable(false);
        addBtn1.setBorderPainted(false);

        newEmployeePanel.add(workedDaysTxt);
        newEmployeePanel.add(daysWorkedInAMonth);
        newEmployeePanel.add(titleLabel1);
        newEmployeePanel.add(nameLabel1);
        newEmployeePanel.add(nameTxt);
        newEmployeePanel.add(lastNameLabel1);
        newEmployeePanel.add(lastNameTxt);
        newEmployeePanel.add(birthDateLabel1);
        newEmployeePanel.add(birthDateTxt);
        newEmployeePanel.add(salaryLabel1);
        newEmployeePanel.add(monthlyRateTxt);
        newEmployeePanel.add(statusLabel1);
        newEmployeePanel.add(status1);
        newEmployeePanel.add(addBtn1);
        add(newEmployeePanel);

        // EMPLOYEE PANEL
        employeePanel = new JPanel();
        employeePanel.setBounds(296, 32, 905, 609);
        employeePanel.setLayout(null);
        employeePanel.setBackground(new Color(242, 213, 195));

        JLabel titleLabel2 = new JLabel("PERSONAL");
        titleLabel2.setFont(actorFont.deriveFont(24f));
        titleLabel2.setForeground(new Color(191, 111, 31));
        titleLabel2.setBounds(384, 20, 168, 50);
        titleLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel importeLabel = new JLabel("IMPORTE TOTAL");
        importeLabel.setBounds(16, 86, 113, 35);
        importeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        importeTotalTxt = new JTextArea();
        importeTotalTxt.setBounds(141, 86, 200, 35);
        importeTotalTxt.setEditable(false);
        importeTotalTxt.setFocusable(false);
        importeTotalTxt.setBorder(BorderFactory.createEmptyBorder());
        importeTotalTxt.setFont(actorFont.deriveFont(11f));

        String[] orderOptions1 = {"BUSCAR POR", "ACTIVO", "VACACIONES", "DESCANSO MEDICO"};
        searchBy = new JComboBox<>(orderOptions1);
        searchBy.setBounds(402, 86, 161, 35);
        searchBy.setBackground(new Color(221, 140, 88));
        searchBy.setBorder(null);
        searchBy.setFocusable(false);

        String[] orderOptions2 = {"ORDENAR POR", "ESTADO", "NOMBRE"};
        orderBy = new JComboBox<>(orderOptions2);
        orderBy.setBounds(577, 86, 161, 35);
        orderBy.setBackground(new Color(221, 140, 88));
        orderBy.setBorder(null);
        orderBy.setFocusable(false);

        editBtn = new JButton("EDITAR");
        editBtn.setBounds(756, 86, 140, 35);
        editBtn.setBackground(new Color(221, 140, 88));
        editBtn.setFocusable(false);
        editBtn.setBorder(null);

        // CREATING TABLE OF EMPLOYEES
        String[] columnNames1 = {"CODIGO", "NOMBRE", "APELLIDO", "TARIFA MENSUAL", "IMPORTE MENSUAL",
                "SUELDO", "DIAS TRABAJO", "ESTADO"};
        employeeModel = new DefaultTableModel(columnNames1, 0);
        employeeTable = new JTable(employeeModel);
        employeeTable.setRowHeight(30);
        employeeTable.getTableHeader().setBackground(new Color(221, 140, 88));
        employeeTable.getTableHeader().setForeground(Color.BLACK);
        employeeTable.getTableHeader().setReorderingAllowed(false);
        employeeTable.getTableHeader().setResizingAllowed(false);

        employeeModel.addRow(new Object[]{"00001", "Juan", "Perez", 1000, 1000, 850, 30, Status.ACTIVO});
        employeeModel.addRow(new Object[]{"00002", "Maria", "Gomez", 2000, 2000, 1700, 30, Status.VACACIONES});

        JScrollPane scrollPane1 = new JScrollPane(employeeTable);
        scrollPane1.setBounds(16, 200, 880, 300);
        scrollPane1.setBorder(BorderFactory.createEmptyBorder());
        scrollPane1.setBackground(new Color(255, 255, 255));
        employeePanel.add(scrollPane1);
        employeePanel.add(editBtn);
        employeePanel.add(searchBy);
        employeePanel.add(orderBy);
        employeePanel.add(importeTotalTxt);
        employeePanel.add(titleLabel2);
        employeePanel.add(importeLabel);
        employeePanel.setVisible(false);
        add(employeePanel);

        // BILLING PANEL

        billingPanel = new JPanel();
        billingPanel.setBounds(296, 32, 905, 609);
        billingPanel.setLayout(null);
        billingPanel.setBackground(new Color(242, 213, 195));

        JLabel titleLabel3 = new JLabel("REGISTRO DE BOLETA DE PAGO");
        titleLabel3.setFont(actorFont.deriveFont(24f));
        titleLabel3.setForeground(new Color(191, 111, 31));
        titleLabel3.setBounds(233, 20, 458, 44);
        titleLabel3.setHorizontalAlignment(SwingConstants.CENTER);

        queueBtn = new JButton("ATENDER COLA");
        queueBtn.setBounds(122, 114, 191, 41);
        queueBtn.setBackground(new Color(221, 140, 88));
        queueBtn.setFocusable(false);
        queueBtn.setBorder(null);

        stackBtn = new JButton("ATENDER PILA");
        stackBtn.setBounds(593, 114, 191, 41);
        stackBtn.setBackground(new Color(221, 140, 88));
        stackBtn.setFocusable(false);
        stackBtn.setBorder(null);

        // CREATING TABLE OF OUTPUT
        String[] columnNames = {"NOMBRE", "APELLIDO", "SALARIO"};
        billingModel = new DefaultTableModel(columnNames, 0);
        billingPaymentTable = new JTable(billingModel);
        billingPaymentTable.setRowHeight(30);
        billingPaymentTable.getTableHeader().setBackground(new Color(221, 140, 88));
        billingPaymentTable.getTableHeader().setForeground(Color.BLACK);
        billingPaymentTable.getTableHeader().setReorderingAllowed(false);
        billingPaymentTable.getTableHeader().setResizingAllowed(false);

        // Agregar datos a la tabla
        billingModel.addRow(new Object[]{"Juan", "Perez", 1000});
        billingModel.addRow(new Object[]{"Maria", "Gomez", 2000});


        JScrollPane scrollPane = new JScrollPane(billingPaymentTable);
        scrollPane.setBounds(122, 200, 662, 300);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBackground(new Color(255, 255, 255));

        billingPanel.add(scrollPane);
        billingPanel.add(queueBtn);
        billingPanel.add(stackBtn);
        billingPanel.add(titleLabel3);
        billingPanel.setVisible(false);


        add(billingPanel);


        // INFORMATION PANEL
        informationPanel = new JPanel();
        informationPanel.setBounds(296, 32, 905, 609);
        informationPanel.setLayout(null);
        informationPanel.setBackground(new Color(242, 213, 195));
        informationPanel.setVisible(false);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 905, 609);
        informationPanel.add(layeredPane);

        ImageIcon background = new ImageIcon(getClass().getResource("/background.png"));
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 905, 609);
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        ImageIcon logo2 = new ImageIcon(getClass().getResource("/logo_2.png"));
        JLabel logo2Label = new JLabel(logo2);
        logo2Label.setBounds(302, 100, 300, 368);
        layeredPane.add(logo2Label, Integer.valueOf(1));

        JLabel location = new JLabel(Empresa.UBICACION);
        location.setFont(actorFont.deriveFont(16f));
        location.setForeground(new Color(191, 111, 31));
        location.setBounds(302, 80, 300, 20);
        location.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(location, Integer.valueOf(2));

        JLabel address = new JLabel(Empresa.DIRECCION);
        address.setFont(actorFont.deriveFont(14f));
        address.setForeground(new Color(191, 111, 31));
        address.setBounds(302, 477, 300, 20);
        address.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(address, Integer.valueOf(2));

        JLabel number = new JLabel(Empresa.TELEFONO);
        number.setFont(actorFont.deriveFont(14f));
        number.setForeground(new Color(191, 111, 31));
        number.setBounds(302, 507, 300, 20);
        number.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(number, Integer.valueOf(2));

        add(informationPanel);

    }

    public void menu() {
        ImageIcon close = new ImageIcon(getClass().getResource("/cerrar.png"));
        closeBtn = new JButton(close);
        closeBtn.setBounds(118, 583, 55, 55);
        closeBtn.setBorder(null);
        closeBtn.setContentAreaFilled(false);
        closeBtn.setFocusPainted(false);
        add(closeBtn);

        ImageIcon newEmployee = new ImageIcon(getClass().getResource("/nuevo_personal.png"));
        newEmployeeBtn = new JButton("NUEVO PERSONAL", newEmployee);
        newEmployeeBtn.setBounds(23, 304, 252, 59);
        newEmployeeBtn.setBorder(null);
        newEmployeeBtn.setFocusPainted(false);
        newEmployeeBtn.setBackground(new Color(221, 140, 88));
        newEmployeeBtn.setHorizontalAlignment(SwingConstants.LEFT);
        add(newEmployeeBtn);

        ImageIcon employee = new ImageIcon(getClass().getResource("/personal.png"));
        employeeBtn = new JButton("PERSONAL", employee);
        employeeBtn.setBounds(23, 380, 252, 59);
        employeeBtn.setBorder(null);
        employeeBtn.setFocusPainted(false);
        employeeBtn.setBackground(new Color(235, 184, 151));
        employeeBtn.setHorizontalAlignment(SwingConstants.LEFT);
        add(employeeBtn);

        ImageIcon information = new ImageIcon(getClass().getResource("/informacion_de_empresa.png"));
        informationBtn = new JButton("INFORMACION DE EMPRESA", information);
        informationBtn.setBounds(23, 461, 252, 59);
        informationBtn.setBorder(null);
        informationBtn.setFocusPainted(false);
        informationBtn.setBackground(new Color(235, 184, 151));
        informationBtn.setHorizontalAlignment(SwingConstants.LEFT);
        add(informationBtn);
        ImageIcon logo = new ImageIcon(getClass().getResource("/logo_empresa.png"));
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(23, 45, 251, 221);
        add(logoLabel);

        // BUTTONS OF PERSONAL DEFAULT FALSE
        employeeBtn2 = new JButton("PERSONAL");
        employeeBtn2.setBounds(296, 12, 152, 20);
        employeeBtn2.setBorder(null);
        employeeBtn2.setFocusPainted(false);
        employeeBtn2.setBackground(new Color(221, 140, 88));
        employeeBtn2.setHorizontalAlignment(SwingConstants.CENTER);
        employeeBtn2.setVisible(false);

        billingBtn = new JButton("BOLETA DE PAGO");
        billingBtn.setBounds(455, 12, 152, 20);
        billingBtn.setBorder(null);
        billingBtn.setFocusPainted(false);
        billingBtn.setBackground(new Color(235, 184, 151));
        billingBtn.setHorizontalAlignment(SwingConstants.CENTER);
        billingBtn.setVisible(false);

        add(employeeBtn2);
        add(billingBtn);


    }

    private void fontSetup() {
        try {
            InputStream fontPath = getClass().getResourceAsStream("/Actor-Regular.ttf");
            actorFont = Font.createFont(Font.TRUETYPE_FONT, fontPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void actionListeners() {
        closeBtn.addActionListener(e -> System.exit(0));
        newEmployeeBtn.addActionListener(e -> {
            buttonPressed(newEmployeeBtn);
            newEmployeeBtn.setBackground(new Color(221, 140, 88));
            employeeBtn.setBackground(new Color(235, 184, 151));
            informationBtn.setBackground(new Color(235, 184, 151));
        });
        employeeBtn.addActionListener(e -> {
            buttonPressed(employeeBtn);
            employeeBtn.setBackground(new Color(221, 140, 88));
            newEmployeeBtn.setBackground(new Color(235, 184, 151));
            informationBtn.setBackground(new Color(235, 184, 151));
        });
        employeeBtn2.addActionListener(e -> {
            buttonPressed(employeeBtn2);
            employeeBtn2.setBackground(new Color(221, 140, 88));
            billingBtn.setBackground(new Color(235, 184, 151));
        });
        billingBtn.addActionListener(e -> {
            buttonPressed(billingBtn);
            billingBtn.setBackground(new Color(221, 140, 88));
            employeeBtn2.setBackground(new Color(235, 184, 151));
        });

        informationBtn.addActionListener(e -> {
            buttonPressed(informationBtn);
            informationBtn.setBackground(new Color(221, 140, 88));
            newEmployeeBtn.setBackground(new Color(235, 184, 151));
            employeeBtn.setBackground(new Color(235, 184, 151));
        });
    }

    private void buttonPressed(JButton button) {
        informationPanel.setVisible(button == informationBtn);
        employeePanel.setVisible(button == employeeBtn);
        billingPanel.setVisible(button == billingBtn);
        if (button == employeeBtn2) {
            if (employeePanel.isVisible()) {
                return;
            } else {
                employeePanel.setVisible(true);
                return;
            }
        }

        if (button == billingBtn) {
            if (!billingPanel.isVisible()) {
                return;
            } else {
                billingPanel.setVisible(true);
                return;
            }
        }

        employeeBtn2.setVisible(button == employeeBtn);
        billingBtn.setVisible(button == employeeBtn);

        newEmployeePanel.setVisible(button == newEmployeeBtn);
    }

}
