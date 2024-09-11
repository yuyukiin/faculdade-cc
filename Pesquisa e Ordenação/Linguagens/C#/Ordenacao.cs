using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OrdenacaoDeObjetos
{


    internal class Ordenacao
    {
        public static void pente(List<Aluno> lista)
        {
            int distancia = lista.Count();
            Aluno tmp;
            int i;
            bool houveTroca;
            do
            {
                distancia = (int)(distancia / 1.3);
                if (distancia < 1) distancia = 1;
                houveTroca = false;
                for (i = 0; i + distancia < lista.Count(); i++)
                {
                    if (lista[i].CompareTo(lista[i + distancia] ) > 0)
                    {
                        tmp = lista[i];
                        lista[i] = lista[i + distancia];
                        lista[i + distancia] = tmp;
                        houveTroca = true;
                    }
                }
            } while (distancia > 1 || houveTroca);

        }
    }
}
