package DAO;

import Model.Debt;

import java.util.List;

public interface IDebtDAO {

    List<Debt> getAllDebts();
    Debt getDebtById(int id);
    void saveDebt(Debt debt);
    void updateDebt(Debt debt,int id);

    void deleteDebt(int id,Boolean reorder);

}
