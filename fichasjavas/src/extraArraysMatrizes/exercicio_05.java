package extraArraysMatrizes;

public class exercicio_05 {
    public static int[] encontrarValoresDuplicados (int[] array)
    {
        int[] vetorNumerosRepetidos = new int[array.length];
        for (int i = 0; i < array.length; i++)
        {
            for (int k = 0; k < array.length; k++)
            {
                if (k != i)
                {
                    if (array[i] == array[k])
                    {

                    }
                }
            }
        }
        return vetorNumerosRepetidos;
    }
}
